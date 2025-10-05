from fastapi import FastAPI, Depends, HTTPException
from fastapi.responses import JSONResponse
from sqlalchemy.orm import Session
import crud, models, schemas
from database import engine, get_db
import json

# Создаем таблицы
models.Base.metadata.create_all(bind=engine)

app = FastAPI()

# @app.post("/items/", response_model=schemas.Item)
# def create_item(item: schemas.ItemCreate, db: Session = Depends(get_db)):
#     return crud.create_item(db, item)

@app.get("/items/{item_id}", response_model=schemas.Item)
def read_item(item_id: int, db: Session = Depends(get_db)):
    db_item = crud.get_item(db, item_id)
    if db_item is None:
        raise HTTPException(status_code=404, detail="Item not found")

    try:
        desc_json = json.loads(db_item.description)
    except json.JSONDecodeError:
        desc_json = db_item.description  # fallback, если это не JSON

    return JSONResponse(content={"description": desc_json})

@app.get("/items/", response_model=list[schemas.Item])
def read_items(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    return crud.get_items(db, skip=skip, limit=limit)

# @app.delete("/items/{item_id}", response_model=schemas.Item)
# def delete_item(item_id: int, db: Session = Depends(get_db)):
#     item = crud.delete_item(db, item_id)
#     if item is None:
#         raise HTTPException(status_code=404, detail="Item not found")
#     return item
