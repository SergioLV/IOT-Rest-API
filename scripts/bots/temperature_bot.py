import requests
import json
from random import uniform
from datetime import datetime

url = "http://localhost:8080/api/v1/data/temperature"

data = {
    "apiKey": "cfb64482-535c-4697-a522-07ce74695e16",
    "jsonData": []
}

# Generate and append data 100 times
for _ in range(200):
    timestamp = datetime.now().isoformat()
    percentage = round(uniform(0, 100), 2)
    data["jsonData"].append({"date": timestamp, "temperature": percentage})
    headers = {'Content-Type': 'application/json'}
    response = requests.post(url, data=json.dumps(data), headers=headers)

    if response.status_code == 202:
        print("Data sent successfully.")
    else:
        print("Failed to send data. Error code:", response.status_code)
        print("Error message:", response.text)
