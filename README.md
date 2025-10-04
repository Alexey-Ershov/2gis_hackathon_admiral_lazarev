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
uvicorn src.main:app --reload

# Kil server
sudo kill $(ps axu | grep uvicorn | awk '{print $2}')

# TODO: curl

