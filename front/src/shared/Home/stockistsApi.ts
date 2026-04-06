import { fetchJson } from '../api/config'

export interface Stockist {
  region: string
  companyName: string
  email: string
  phone: string
}

export const getStockists = async (): Promise<Stockist[]> => {
  return fetchJson<Stockist[]>('/stockists')
}
