
# Realty Summary — Frontend (Vite + React + TS + Tailwind + Effector + FSM)

Фронтенд-проект как отдельный сервис. Структура ориентирована на масштабируемость (Feature-Sliced), Effector для бизнес-логики и небольшой утилитный FSM для предсказуемых сценариев.

## Быстрый старт
```bash
npm i
npm run dev
# или pnpm i && pnpm dev
```

Настройте `.env` (см. `.env.example`):
```env
VITE_API_URL=http://localhost:8787
```

## Структура
- `src/app` — ядро приложения (роутер, layout)
- `src/pages` — страницы: landing, search, developer, complex, compare, tma/shell
- `src/entities` — доменные модули (developer/...)
- `src/features` — независимые фичи (ai-summary/...)
- `src/widgets` — крупные композиции UI (SearchBar и т.д.)
- `src/shared` — общие модули: api-клиент, fsm, типы, env

## Заметки
- Все интеграции с API централизованы в `src/shared/api/client.ts` и в entity/feature `api.ts`.
- Effector-модели расположены рядом с сущностями/фичами.
- TMA-оболочка (`/tma`) использует те же страницы с компактным variant='tma'.
- Tailwind настроен, базовые карточки и отступы добавлены.
- В демо добавлены заглушки поиска и популярные застройщики — подключите реал-эндпоинты на бэке.
