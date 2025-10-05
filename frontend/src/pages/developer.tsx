
import { useEffect } from 'react'
import { useParams } from 'react-router-dom'
import { useUnit } from 'effector-react'
import { developerRequested, $developer } from '@entities/developer/model'
// import { DeveloperHeader } from '@entities/developer/ui'
import { AISummaryCard } from '@features/ai-summary/ui'

export function DeveloperPage({ variant }: { variant?: 'tma' }) {
  const { id } = useParams()
  const dev = useUnit($developer)

  useEffect(() => {
    if (id) developerRequested({ id })
  }, [id])

  if (!dev) return <div>Загрузка…</div>

  return (
    <div className={variant === 'tma' ? 'space-y-3' : 'space-y-6'}>
      {/*<DeveloperHeader dev={dev} />*/}
      <AISummaryCard entityType="developer" entityId={dev.id} />
      <div className="card p-4">
        <div className="font-semibold">Жилые комплексы</div>
        <div className="text-sm opacity-70 mt-1">Список/карта комплексов — интегрируется позже</div>
      </div>
    </div>
  )
}
