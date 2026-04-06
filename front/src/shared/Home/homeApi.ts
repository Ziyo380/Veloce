import { fetchJson, getAssetUrl } from '../api/config'

export interface Product {
  id: number
  name: string
  description: string
  category: string
  imageUrl: string
}

export interface HomeResponse {
  heroText: string
  description: string
  featuredProduct: Product
  products: Product[]
}

export type HomeHeroPayload = {
  promoTitle: string
  promoButtonText: string
  promoButtonLink: string
  promoImageUrl: string
  description: string
  aboutButtonText: string
  aboutButtonLink: string
}

interface ApiProduct {
  id?: number | null
  name: string
  description: string
  category: string
  imageUrl: string
}

const normalizeProduct = (product: ApiProduct, fallbackId: number): Product => ({
  id: product.id ?? fallbackId,
  name: product.name,
  description: product.description,
  category: product.category,
  imageUrl: getAssetUrl(product.imageUrl),
})

export const getHomeData = async (): Promise<HomeResponse> => {
  const data = await fetchJson<{
    heroText: string
    description: string
    featuredProduct: ApiProduct
    products: ApiProduct[]
  }>('/home')

  return {
    heroText: data.heroText,
    description: data.description,
    featuredProduct: normalizeProduct(data.featuredProduct, 0),
    products: data.products.map((product, index) => normalizeProduct(product, index + 1)),
  }
}

export const getHomeHero = async (): Promise<HomeHeroPayload> => {
  const data = await getHomeData()

  return {
    promoTitle: data.heroText,
    promoButtonText: 'SHOP NOW',
    promoButtonLink: '/stocklists',
    promoImageUrl: data.featuredProduct.imageUrl,
    description: data.featuredProduct.description,
    aboutButtonText: 'ABOUT US',
    aboutButtonLink: '/about',
  }
}
