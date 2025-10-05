
export type Id = string
export type Sentiment = 'pos'|'neu'|'neg'

export interface Developer {
  id: Id; name: string; logo?: string;
  foundedAt?: string; reliabilityIndex?: number; summary?: string;
  city?: string; yearsOnMarket?: number; socials?: Record<string,string>;
}

export interface Complex {
  id: Id; developerId: Id; name: string; status: 'built'|'under-construction';
  city?: string; priceRange?: [number, number]; photos?: string[]; dgisUrl?: string; summary?: string;
}

export interface Review {
  id: Id; entityType: 'developer'|'complex'; entityId: Id; source: string;
  createdAt: string; sentiment: Sentiment; tags: string[]; text: string;
}
