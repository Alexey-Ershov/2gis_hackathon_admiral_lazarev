from typing import Optional
from typing import Any

from pydantic import BaseModel

class ItemBase(BaseModel):
    description: Any

class ItemCreate(ItemBase):
    pass

class Item(ItemBase):
    id: int

    class Config:
        orm_mode = True
