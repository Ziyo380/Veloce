import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import { getHomeHero, type HomeHeroPayload } from '../../../shared/api/homeApi'
import styles from './HomeHero.module.scss'

export const HomeHero = () => {
  const [content, setContent] = useState<HomeHeroPayload | null>(null)

  useEffect(() => {
    const load = async () => {
      const data = await getHomeHero()
      setContent(data)
    }

    void load()
  }, [])

  if (!content) {
    return null
  }

  return (
    <section className={styles.hero}>
      <div className={styles.hero__visual}>
        <img src={content.promoImageUrl} alt="Veloce aperitif" className={styles.hero__background} />
        <div className="container">
          <div className={styles.hero__visualContent}>
            <div className={styles.hero__panel}>
              <h2 className={styles.hero__panelTitle}>{content.promoTitle}</h2>
              <Link to={content.promoButtonLink} className={styles.hero__panelButton}>
                {content.promoButtonText}
              </Link>
            </div>
          </div>
        </div>
      </div>

      <div className="container">
        <h1 className={styles.hero__description}>{content.description}</h1>

        <Link to={content.aboutButtonLink} className={styles.hero__aboutButton}>
          {content.aboutButtonText}
        </Link>
      </div>
    </section>
  )
}
