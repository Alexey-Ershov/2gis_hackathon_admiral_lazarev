# Hackathon Backend (FastAPI + PostgreSQL)

## Build

```bash
# Environment activation
python3 -m venv venv
source venv/bin/activate   # Glorious GNU/Darwin
# microsoft --must --die   # venv\Scripts\activate    # Windows

# Dependencies installation
pip install -r requirements.txt

# Run server
uvicorn main:app --reload

# Kil server
sudo kill $(ps axu | grep uvicorn | awk '{print $2}')

# curl GET
curl "http://127.0.0.1:8000/items/<ID>"
```

## Docs
### Swagger UI
http://127.0.0.1:8000/docs

### ReDoc
http://127.0.0.1:8000/redoc

