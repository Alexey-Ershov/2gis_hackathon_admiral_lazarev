
export function ComparePage({ variant }: { variant?: 'tma' }) {
  return (
    <div className={variant === 'tma' ? 'space-y-3' : 'space-y-6'}>
      <h1 className="text-2xl font-semibold">Сравнение</h1>
      <div className="card p-4">Добавьте 2–4 сущности для сравнения.</div>
    </div>
  )
}
