export interface Stockist {
  region: string
  companyName: string
  email: string
  phone: string
}

const API_URL = 'http://localhost:8080/api'

export const getStockists = async (): Promise<Stockist[] | null> => {
  try {
    const response = await fetch(`${API_URL}/stockists`)
    if (!response.ok) return null
    return await response.json()
  } catch (error) {
    console.error('Error fetching stockists data:', error)
    return null
  }
}
