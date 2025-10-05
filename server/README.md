# Hackathon Backend (FastAPI + PostgreSQL)

## Build

```bash
# Environment activation
python3 -m venv venv
source venv/bin/activate   # Glorious GNU/Darwin
# microsoft --must --die   # venv\Scripts\activate    # Windows

# Dependencies installation
pip install -r requirements.txt
```

## Database
createdb 2gis_hack
psql -U postgres -d 2gis_hack -f 2gis_hack.sql

## Run server
uvicorn main:app --reload

## Kill server
sudo kill $(ps axu | grep uvicorn | awk '{print $2}')

## curl GET
curl "http://158.160.1.104:8000/items/"
curl "http://158.160.1.104:8000/items/<ID>"

## Docs
### Swagger UI
http://158.160.1.104/docs

### ReDoc
http://158.160.1.104/redoc

