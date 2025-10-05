
export type State = 'idle' | 'loading' | 'ready' | 'error'
export interface FSM { state: State; error?: string }

export const toLoading = (): FSM => ({ state: 'loading' })
export const toReady = (): FSM => ({ state: 'ready' })
export const toError = (e: unknown): FSM => ({ state: 'error', error: String(e) })
