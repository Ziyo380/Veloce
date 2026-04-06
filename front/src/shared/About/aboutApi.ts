import { fetchJson, getAssetUrl } from '../api/config'
import type { AboutData } from './model/types/about'

interface AboutApiResponse {
  description: string
  establishedYear: number | null
  founder: {
    name: string
    imageUrl: string
  }
  awards: Array<{
    year: number
    title: string
  }>
  contact: {
    phone: string
    email: string
    social: string | null
  }
}

export const getAboutData = async (): Promise<AboutData> => {
  const data = await fetchJson<AboutApiResponse>('/about')

  return {
    heroText: data.description,
    recognition: data.awards.map((award) => ({
      year: String(award.year),
      title: award.title,
    })),
    founderName: data.founder.name,
    founderImage: getAssetUrl(data.founder.imageUrl),
    productionImage: getAssetUrl('/bg_5.jpg'),
    contact: {
      phone: data.contact.phone,
      email: data.contact.email,
      social: data.contact.social ?? '@veloce',
    },
    establishedYear: data.establishedYear ? String(data.establishedYear) : '2022',
  }
}
