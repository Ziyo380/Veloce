import styles from './FindUsBanner.module.scss'
import type { Stockist } from '../../../shared/Home/stockistsApi'

interface FindUsBannerProps {
  stockists: Stockist[]
}

export const FindUsBanner = ({ stockists }: FindUsBannerProps) => {
  return (
    <section className={styles.banner}>
      <div className={styles.bgImage}></div>

      <div className={styles.content}>
        <h4 className={styles.title}>OUR STOCK LISTS</h4>
        <div className={styles.list}>
          {stockists.map((item, index) => (
            <div
              key={`${item.region}-${item.companyName}`}
              className={styles.item}
              style={{ borderBottom: index === stockists.length - 1 ? '1px solid #000' : 'none' }}
            >
              <div className={styles.itemRegion}>{item.region}</div>
              <div className={styles.itemDetails}>
                <span>{item.companyName}</span>
                <span>{item.email}</span>
                <span>{item.phone}</span>
              </div>
            </div>
          ))}
        </div>
      </div>
    </section>
  )
}
