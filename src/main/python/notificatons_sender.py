import requests
import os
import json

API_URL = "http://localhost:8080/subscription"

HOME_DIR = os.path.abspath(os.path.join("../..", os.pardir))
FILE_DIR = os.path.join(HOME_DIR, "notificacoes.txt")


def read_notifications():
    notificacoes = []
    with open(FILE_DIR, mode="r") as f:
        for line in f.readlines():
            line = line.rstrip()
            notificacoes.append(line)

    return notificacoes


def send_notifications():
    notificacoes = read_notifications()

    with requests.sessions.Session() as session:
        for n in notificacoes:
            if n.strip():
                with session.post(API_URL, json=json.dumps(n)) as req:
                    print(req.status_code)


if __name__ == "__main__":
    read_notifications()
