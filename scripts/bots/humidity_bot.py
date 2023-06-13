import requests
import json
from random import uniform
from datetime import datetime

url = "http://localhost:8080/api/v1/data/humidity"

data = {
    "apiKey": "93a867c7-2a3b-4a89-9a8a-c6f956c3cb9b",
    "jsonData": []
}

# Generate and append data 100 times
for _ in range(200):
    timestamp = datetime.now().isoformat()
    percentage = round(uniform(0, 100), 2)
    data["jsonData"].append({"date": timestamp, "percentage": percentage})
    headers = {'Content-Type': 'application/json'}
    response = requests.post(url, data=json.dumps(data), headers=headers)

    if response.status_code == 202:
        print("Data sent successfully.")
    else:
        print("Failed to send data. Error code:", response.status_code)
        print("Error message:", response.text)
