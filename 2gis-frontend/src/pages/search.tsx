
import { useSearchParams, Link } from 'react-router-dom'

export function SearchPage({ variant }: { variant?: 'tma' }) {
  const [sp] = useSearchParams()
  const q = sp.get('q') ?? ''

  // Placeholder; integrate real search later
  const results = q ? [
    { id: 'dev-1', name: 'ООО Надежный Дом', type: 'developer' },
    { id: 'cplx-1', name: 'ЖК Солнечный', type: 'complex' },
  ] : []

  return (
    <div className={variant === 'tma' ? 'py-2 space-y-3' : 'space-y-4'}>
      <h1 className="text-xl font-semibold">Результаты поиска</h1>
      {!q && <div className="opacity-70">Уточните запрос…</div>}
      <ul className="space-y-2">
        {results.map((r) => (
          <li key={r.id} className="card p-3 flex justify-between">
            <div className="font-medium">{r.name}</div>
            {r.type === 'developer' ? (
              <Link to={`/developer/${r.id}`} className="text-sm underline">Открыть</Link>
            ) : (
              <Link to={`/complex/${r.id}`} className="text-sm underline">Открыть</Link>
            )}
          </li>
        ))}
      </ul>
    </div>
  )
}
