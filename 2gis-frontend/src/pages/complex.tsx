
import { AISummaryCard } from '@features/ai-summary/ui'
import { useParams } from 'react-router-dom'

export function ComplexPage({ variant }: { variant?: 'tma' }) {
  const { id } = useParams()
  const complexId = id ?? 'complex-unknown'
  return (
    <div className={variant === 'tma' ? 'space-y-3' : 'space-y-6'}>
      <h1 className="text-2xl font-semibold">ЖК (демо)</h1>
      <AISummaryCard entityType="complex" entityId={complexId} />
      <div className="card p-4">
        Фото / инфраструктура / планировки — интегрируется позже
      </div>
    </div>
  )
}
