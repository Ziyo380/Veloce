const DEFAULT_API_ORIGIN = 'http://localhost:8080'

const normalizePath = (value: string) => (value.startsWith('/') ? value : `/${value}`)

export const API_ORIGIN = import.meta.env.VITE_API_ORIGIN ?? DEFAULT_API_ORIGIN
export const API_BASE_URL = import.meta.env.VITE_API_BASE_URL ?? `${API_ORIGIN}/api`

export const fetchJson = async <T>(endpoint: string, init?: RequestInit): Promise<T> => {
  const response = await fetch(`${API_BASE_URL}${normalizePath(endpoint)}`, {
    headers: {
      Accept: 'application/json',
      ...init?.headers,
    },
    ...init,
  })

  if (!response.ok) {
    throw new Error(`Request failed: ${response.status} ${response.statusText}`)
  }

  return response.json() as Promise<T>
}

export const getAssetUrl = (path: string) => {
  if (!path) {
    return ''
  }

  if (/^https?:\/\//i.test(path)) {
    return path
  }

  return `${API_ORIGIN}${normalizePath(path)}`
}
