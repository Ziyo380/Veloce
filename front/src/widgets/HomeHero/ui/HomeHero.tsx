// src/widgets/HomeHero/ui/HomeHero.tsx
import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import { getHomeData, type HomeResponse } from '../../../shared/Home/homeApi'
import styles from './HomeHero.module.scss'

export const HomeHero = () => {
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

  if (loading) {
    return (
      <div className={styles.hero} style={{ minHeight: '600px', display: 'flex', alignItems: 'center', justifyContent: 'center', background: '#f5f5f5' }}>
        <div style={{ fontSize: '1.2rem', fontFamily: 'var(--font-family)', color: '#333' }}>Loading Veloce...</div>
      </div>
    )
  }

  if (!data) {
    return null
  }

  const { heroText, featuredProduct } = data

  return (
    <section className={styles.hero}>
      <div className={styles.hero__visual}>
        {/* We use /bg_1.jpg here directly as the backend doesn't provide a hero cover image */}
        <img src="/bg_1.jpg" className={styles.hero__background} alt="Hero Background" />

        {/* Оранжевый блок — от края экрана до 40% */}
        <div className={styles.hero__panel}>
          {/* Внутренний контейнер для выравнивания текста по сетке */}
          <div className="container">
            <div className={styles.hero__panelContent}>
              <h2 className={styles.hero__panelTitle}>{heroText}</h2>
              <Link to="/stocklists" className={styles.hero__panelButton}>
                SHOP NOW
              </Link>
            </div>
          </div>
        </div>
      </div>
      <div className={styles.hero__descr}>
        <div className="container">
          <h3 className={styles.hero__descr__title}>{featuredProduct.description}</h3>
          <Link to="/about" className={styles.hero__about__btn}>
            ABOUT US
          </Link>
        </div>
      </div>
    </section>
  )
}