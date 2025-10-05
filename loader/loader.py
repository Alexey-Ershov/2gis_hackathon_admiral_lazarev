import requests
import json
import sys

url = "https://gigachat.devices.sberbank.ru/api/v1/chat/completions"

builder = "застройщик " + sys.argv[1] + " достоинства"
print(f"{builder}")

payload = json.dumps({
  "model": "GigaChat-2-Max",
  "stream": False,
  "update_interval": 0,
  "messages": [
    {
      "role": "system",
      "content": "Отвечай как эксперт по недвижимости"
    },
    {
      "role": "user",
      "content": builder
    }
  ]
})
headers = {
  'Content-Type': 'application/json',
  'X-Request-ID': '79e41a5f-f180-4c7a-b2d9-393086ae20a1',
  'X-Session-ID': 'b6874da0-bf06-410b-a150-fd5f9164a0b2',
  'X-Client-ID': 'posttman-request-collection',
  'Authorization': 'Bearer eyJjdHkiOiJqd3QiLCJlbmMiOiJBMjU2Q0JDLUhTNTEyIiwiYWxnIjoiUlNBLU9BRVAtMjU2In0.E2m32Y6UWefJtwXOKJY80X7Zw3e7uyH_ro7vE20n9-tZzvZhGBmLzDPQev9x4BFmB0e0sva0UiTsRYbfdewE1LSTE8wYgqUlQwbF40FHgCgk-evczD4j17aZRPODney1CqQds_yX6-VjADU1sWIFlDXjw76pcW8AoZQ46evUqbQBxh2fvBkjspQgvH8Rkkf-rCk5KR64k-VmjAY4ZtWZzP-mi8SA4Jx3m41bES4TqOviWM_Usdd239MNOFSE9-oVd2m4tcSFo4z0ZIIE8UiUwkbb3-VY6tf9NECE0jFzfYTLb7cMyYbFyXIFINA2W2Fk72bDoJGYOIx2Zh4kf17W8w.e9uejiCJ3LMnw_JwzwoQiA.sC7pelHtgNvLFxs_rU5LmYzruFGl72Wuxrkuu0Dcbujl5JZaZecxaNeaUNWi7yP2uQRodVfjxUtC4jL5ugmHLIt-t1nkE9FXjamH0tslD4TxeLk4JChT7ohbE14Gid6225AnMSflJ99JZz9lhhXNBU2ITTHtwHnREQ9AHHyP-aSAXb-84DYo3P6JfCAgfy6sbTLSmUWt5H1Q6GIjdqriaR_oncI8P3CpmoH80xhPgK6mGAZSPAHwziDZ-QQNTNu8C54I43XQSQ7rIEEEgHzPW45YRFknALNiVrgTphRtX1ouurmQd3MqOTdpJ_o-XT2eWOkSt030XOnYo2hngD3-bZFdaUzBnI83oO6mYGF1LtpyKVIHOw0WHVar_r2_cYOQH0513WUz9gb0k1QSABfkNhzTtf58551TDEO-z_VUhb1H5uPI2uQKiN191pc2HfPbZS4m3NxQpP-2Nk5PJByHkLgxuRbNDu-kMkuEVxdvCrcigB7jahCnU_R9ZkLCW0sKQXsbfqNXVGaCEQfZwnDo_mD_vx_k0aLZtsbXm7ZXkPcpdZZS3LNPaR3KR1p7c8q0BALkcysTD0iJNBpdpwPiKBgzCiyb0mXGRQt5fiAIM1JjBJwI5iLsFifJGouvEqcS1nvmLfbKJhHNID7EcPngePU7tFV_6cZ2hsiaM13GYcuR_PDzfII3hA5cEyiUXcCMrYPxWBfm07rzEeIcFBbNWaFWc8j0i0aBLvHxtLIATu0.MKSITT2Lj4-SWJ3s-_prSfpX9UA7FlQGa1079cgWk_Q'
}

response = requests.request("POST", url, headers=headers, data=payload, verify=False)

print(response.text)

file = open("result.json", "w")

# Write text to the file
file.write(response.text)

# Close the file to save the changes
file.close() 