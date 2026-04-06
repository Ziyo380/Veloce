import { useEffect, useState } from 'react'
import { getAboutData } from '../../../shared/About/aboutApi'
import type { AboutData } from '../../../shared/About/model/types/about'
import { AboutHero } from '../../../widgets/AboutHero'
import { AboutGrid } from '../../../widgets/AboutGrid'
import { Footer } from '../../../widgets/Footer'

export const AboutPage = () => {
  const [data, setData] = useState<AboutData | null>(null)
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    const loadData = async () => {
      try {
        const response = await getAboutData()
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

  return (
    <main>
      <AboutHero text={data.heroText} />
      <AboutGrid data={data} />
      <Footer variant="white" />
    </main>
  )
}
