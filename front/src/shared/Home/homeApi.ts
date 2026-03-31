export interface Product {
  id: number
  name: string
  description: string
  category: string
  imageUrl: string
}

export interface HomeResponse {
  heroText: string
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

const API_URL = 'http://localhost:8080/api'

export const getHomeData = async (): Promise<HomeResponse | null> => {
  try {
    const response = await fetch(`${API_URL}/home`)
    if (!response.ok) return null
    return await response.json()
  } catch (error) {
    console.error('Error fetching home data:', error)
    return null
  }
}

// Keeping getHomeHero for backward compatibility while transition happens, 
// but mapping it to getHomeData's output
export const getHomeHero = async (): Promise<HomeHeroPayload> => {
  const data = await getHomeData()

  if (!data) {
    return {
      promoTitle: 'THE ONLY SPIRIT-FREE APERITIF THAT TASTES AS GOOD AS IT MAKES YOU FEEL.',
      promoButtonText: 'SHOP NOW',
      promoButtonLink: '/stocklists',
      promoImageUrl: '/bg_1.jpg',
      description:
        'VÉLOCE IS THE ZERO-PROOF APERITIF FOR MODERN LIVING, CRAFTED WITH SUPER HERBS AND NUTRACEUTICALS TO ELEVATE YOUR WELL-BEING, WITHOUT COMPROMISING THE SOPHISTICATED RITUAL OF THE APERITIF.',
      aboutButtonText: 'ABOUT US',
      aboutButtonLink: '/about',
    }
  }

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
