from typing import Optional

from pydantic import BaseModel

class ItemBase(BaseModel):
    description: str

class ItemCreate(ItemBase):
    pass

class Item(ItemBase):
    id: int

    class Config:
        orm_mode = True
