import { useEffect, useState } from 'react'
import { getStockists, type Stockist } from '../../../shared/Home/stockistsApi'
import { FindUsBanner } from '../../../widgets/FindUsBanner'
import { Footer } from '../../../widgets/Footer'

export const FindUsPage = () => {
  const [stockists, setStockists] = useState<Stockist[]>([])
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    const loadStockists = async () => {
      try {
        const data = await getStockists()
        setStockists(data)
      } finally {
        setLoading(false)
      }
    }

    void loadStockists()
  }, [])

  if (loading) {
    return null
  }

  return (
    <main>
      <FindUsBanner stockists={stockists} />
      <Footer variant="white" />
    </main>
  )
}
