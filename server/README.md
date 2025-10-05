# AdmiralLazarev Team

## Hackathon Backend (FastAPI + PostgreSQL)

## Requirements
    - OS: Any appropriate Linux like Debian-based or RPM based
    - python3
    - postgresql

    - (In the future releases: docker or we'll make it before the code freeze :)')

## Build

```bash
# Environment activation
python3 -m venv venv
source venv/bin/activate   # Glorious GNU/Darwin
# venv\Scripts\activate    # Windows

# Dependencies installation
pip install -r requirements.txt
```

## Database
sudo -u postgres createdb 2gis_hack
sudo -u postgres psql -U postgres -d 2gis_hack -f 2gis_hack.sql

## Run server
uvicorn main:app --host 127.0.0.1 --port 8000 --reload

## curl GET
curl "http://158.160.1.104:8000/items/"
curl "http://158.160.1.104:8000/items/<ID>"

## Docs
### Swagger UI
http://158.160.1.104/docs

### ReDoc
http://158.160.1.104/redoc

