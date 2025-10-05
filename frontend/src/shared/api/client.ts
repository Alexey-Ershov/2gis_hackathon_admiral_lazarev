
import ky from 'ky'

export const api = ky.create({
  timeout: 8000,
  hooks: {
    beforeRequest: [
      req => {
        // place for auth header or tma signature
      }
    ]
  }
})
