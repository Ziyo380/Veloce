import { useEffect, useState } from 'react'
import { getHomeData, type HomeResponse } from '../../../shared/Home/homeApi'
import { HomeHero } from '../../../widgets/HomeHero'
import { CollectionSlider } from '../../../widgets/CollectionSlider'
import { ProductList } from '../../../widgets/ProductList'
import { FeaturedProduct } from '../../../widgets/Banner'
import { Footer } from '../../../widgets/Footer'

export const HomePage = () => {
  const [data, setData] = useState<HomeResponse | null>(null)
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    const loadData = async () => {
      try {
        const response = await getHomeData()
        setData(response)
      } finally {
        setLoading(false)
      }
    }

    void loadData()
  }, [])

  if (loading || !data) {
    return null
  }

  const { heroText, description, featuredProduct, products } = data

  return (
    <main>
      <HomeHero heroText={heroText} description={description} />
      <FeaturedProduct product={featuredProduct} />
      <ProductList products={products} />
      <CollectionSlider featured={featuredProduct} collections={products} />
      <Footer variant="orange" />
    </main>
  )
}
