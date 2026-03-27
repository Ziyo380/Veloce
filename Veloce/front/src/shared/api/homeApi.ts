export type HomeHeroPayload = {
  promoTitle: string
  promoButtonText: string
  promoButtonLink: string
  promoImageUrl: string
  description: string
  aboutButtonText: string
  aboutButtonLink: string
}

const fallbackHomeHero: HomeHeroPayload = {
  promoTitle: 'THE ONLY SPIRIT-FREE APERITIF THAT TASTES AS GOOD AS IT MAKES YOU FEEL.',
  promoButtonText: 'SHOP NOW',
  promoButtonLink: '/stocklists',
  promoImageUrl: 'http://localhost:8080/lavanda.jpg',
  description:
    'VÉLOCE IS THE ZERO-PROOF APERITIF FOR MODERN LIVING, CRAFTED WITH SUPER HERBS AND NUTRACEUTICALS TO ELEVATE YOUR WELL-BEING, WITHOUT COMPROMISING THE SOPHISTICATED RITUAL OF THE APERITIF.',
  aboutButtonText: 'ABOUT US',
  aboutButtonLink: '/about',
}

export const getHomeHero = async (): Promise<HomeHeroPayload> => {
  try {
    const response = await fetch('http://localhost:8080/api/home')

    if (!response.ok) {
      return fallbackHomeHero
    }

    const data = await response.json()

    return {
      promoTitle: data.promoTitle ?? fallbackHomeHero.promoTitle,
      promoButtonText: data.promoButtonText ?? fallbackHomeHero.promoButtonText,
      promoButtonLink: data.promoButtonLink ?? fallbackHomeHero.promoButtonLink,
      promoImageUrl: data.promoImageUrl ?? fallbackHomeHero.promoImageUrl,
      description: data.description ?? fallbackHomeHero.description,
      aboutButtonText: data.aboutButtonText ?? fallbackHomeHero.aboutButtonText,
      aboutButtonLink: data.aboutButtonLink ?? fallbackHomeHero.aboutButtonLink,
    }
  } catch {
    return fallbackHomeHero
  }
}
