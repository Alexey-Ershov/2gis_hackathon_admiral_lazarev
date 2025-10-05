
import { useUnit } from 'effector-react'
import { $summary, $summaryPending, summaryRequested } from './model'

export function AISummaryCard(props: { entityType: 'developer'|'complex', entityId: string }) {
  const [summary, pending] = useUnit([$summary, $summaryPending])

  return (
    <div className="card p-4">
      <div className="flex items-center justify-between">
        <h3 className="font-semibold">AI Summary</h3>
        <button
          className="px-3 py-1.5 rounded-xl bg-gray-900 text-white text-sm"
          onClick={() => summaryRequested(props)}
          disabled={pending}
        >
          {pending ? 'Анализ...' : 'Обновить'}
        </button>
      </div>
      <div className="mt-2 text-sm leading-6">
        {summary?.summary ?? 'Нажмите «Обновить», чтобы получить сводку.'}
      </div>
      {summary?.reliabilityIndex != null && (
        <div className="mt-2 text-xs opacity-70">
          Индекс надёжности (LLM): {summary.reliabilityIndex}
        </div>
      )}
    </div>
  )
}
