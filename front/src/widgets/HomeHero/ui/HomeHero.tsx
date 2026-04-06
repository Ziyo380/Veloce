import { Link } from 'react-router-dom'
import styles from './HomeHero.module.scss'

interface HomeHeroProps {
  heroText: string
  description: string
}

export const HomeHero = ({ heroText, description }: HomeHeroProps) => {
  return (
    <section className={styles.hero}>
      <div className={styles.hero__visual}>
        <img src="/bg_1.jpg" className={styles.hero__background} alt="Hero Background" />

        <div className={styles.hero__panel}>
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
          <h3 className={styles.hero__descr__title}>{description}</h3>
          <Link to="/about" className={styles.hero__about__btn}>
            ABOUT US
          </Link>
        </div>
      </div>
    </section>
  )
}
