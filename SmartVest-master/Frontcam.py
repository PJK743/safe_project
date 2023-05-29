import os
import boto3
import cv2
import datetime
from dotenv import load_dotenv
from urllib.parse import urlencode, unquote

load_dotenv()
regeion_name2 = os.environ.get("regeion_name")
aws_key_id = os.environ.get("aws_access_key_id")
aws_access_key = os.environ.get("aws_secret_access_key")


def s3_connection():
    try:
        s3 = boto3.client(
            service_name="s3",
            region_name=unquote(regeion_name2),
            aws_access_key_id=unquote(aws_key_id),
            aws_secret_access_key=unquote(aws_access_key),
        )
    except Exception as e:
        print(e)
    else:
        print("s3 bucket connected!")
        return s3


def upload_to_s3():
    s3 = s3_connection()

    folder_path = "/home/c2erish/FinalProject/cam_save"

    # 최신 파일 찾기
    latest_file = max(
        (f.path for f in os.scandir(folder_path) if f.is_file()), key=os.path.getctime
    )

    for filename in os.listdir(folder_path):
        if filename == os.path.basename(latest_file):
            continue

        try:
            with open(os.path.join(folder_path, filename), "rb") as f:
                s3.upload_fileobj(
                    f,
                    "project-s3-data",
                    filename,
                )
        except Exception as e:
            print(e)
        else:
            os.remove(os.path.join(folder_path, filename))


def front_cam():
    print("cam이 실행되었습니다.")
    cap = cv2.VideoCapture(2)
    fourcc = cv2.VideoWriter_fourcc(*"AVC1")  # 코덱 H264, AVC1
    save_time = 60  # 초 단위
    s_frame = 30  # 1초동안 프레임 30x10 = 3002
    # ex) 1분 프레임 30x60 = 1800
    current_time = datetime.datetime.now().strftime("%Y-%m-%d_%H-%M-%S")
    filename = "/home/c2erish/FinalProject/cam_save/" + current_time + ".mp4"
    out = cv2.VideoWriter(filename, fourcc, 30.0, (640, 480))
    start_time = datetime.datetime.now()
    while True:
        ret, frame = cap.read()
        out.write(frame)

        if (datetime.datetime.now() - start_time).seconds >= save_time:
            out.release()
            current_time = datetime.datetime.now().strftime("%Y-%m-%d_%H-%M-%S")
            out = cv2.VideoWriter(filename, fourcc, s_frame, (640, 480))
            try:
                upload_to_s3()
            except Exception as e:
                print(e)

            start_time = datetime.datetime.now()

        if cv2.waitKey(1) & 0xFF == ord("q"):
            break

    cap.release()
    out.release()
    cv2.destroyAllWindows()
