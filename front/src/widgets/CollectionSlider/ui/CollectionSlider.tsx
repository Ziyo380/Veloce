import React, { useState } from 'react'
import { motion, AnimatePresence } from 'framer-motion'
import type { Product } from '../../../shared/Home/homeApi'
import { getAssetUrl } from '../../../shared/api/config'
import { useTypewriter } from '../lib/useTypewriter'
import styles from './CollectionSlider.module.scss'

interface CollectionSliderProps {
  featured: Product
  collections: Product[]
}

// ── Вспомогательный компонент для каждой кнопки навигации ─────────────────────
// Определяем ВНЕ основного компонента, чтобы не было ошибки пересоздания хуков
const NavButton: React.FC<{
  name: string
  isActive: boolean
  trigger: number
  onClick: () => void
}> = ({ name, isActive, trigger, onClick }) => {
  const { text, isBusy } = useTypewriter(name, trigger)

  return (
    <button
      className={`${styles.nameBtn} ${isActive ? styles['nameBtn--active'] : ''}`}
      onClick={onClick}
      type="button"
    >
      {isActive ? (
        <>
          {text}
          <span className={`${styles.cursor} ${isBusy ? '' : styles['cursor--blink']}`} aria-hidden="true" />
        </>
      ) : (
        name
      )}
    </button>
  )
}

export const CollectionSlider: React.FC<CollectionSliderProps> = ({
  featured,
  collections,
}) => {
  // Объединяем уникальные слайды из API
  const slides = [featured, ...collections].filter(
    (v, i, a) => a.findIndex((t) => t.id === v.id) === i
  )

  // Контент для специального пункта FIND US (из дизайна)
  const findUsContent = {
    id: 'find_us',
    name: 'FIND US',
    description: 'EXPERIENCE THE REFINED TASTE OF VÉLOCE. VISIT OUR PREMIUM STOCKISTS FOR YOUR NEXT ALCOHOL-FREE APERITIF.',
    imageUrl: getAssetUrl('/bg_3.jpg')
  }

  // Общий тип для активного контента (продукт или FIND US)
  type Content = {
    id: number | string
    description: string
    imageUrl: string
  }

  const [activeContent, setActiveContent] = useState<Content>({
    id: featured.id,
    description: featured.description,
    imageUrl: featured.imageUrl
  })
  const [activeId, setActiveId] = useState<number | string>(featured.id)
  const [clickTrigger, setClickTrigger] = useState(0)

  // Полный список имен для навигации
  const navigationItems = [
    ...slides.map((s) => ({ id: s.id, name: s.name.toUpperCase(), data: s })),
    { id: findUsContent.id, name: findUsContent.name, data: findUsContent }
  ]

  const handleSelect = (id: number | string, data: any) => {
    setActiveContent({
      id: data.id,
      description: data.description,
      imageUrl: data.imageUrl
    })
    setActiveId(id)
    setClickTrigger((prev) => prev + 1)
  }

  return (
    <section className={styles.slider}>
      {/* ── Блок 1: Навигация (Золотистый) ── */}
      <div className={styles.navBlock}>
        <div className="container">
          {/* <div className={styles.navContent}> */}
          <div className={styles.namesList}>
            {navigationItems.map((item) => (
              <NavButton
                key={item.id}
                name={item.name}
                isActive={item.id === activeId}
                trigger={clickTrigger}
                onClick={() => handleSelect(item.id, item.data)}
              />
            ))}
          </div>
        </div>
        {/* </div> */}
      </div>

      {/* ── Блок 2: Контент (Светлый) — стык в стык ── */}
      <div className={styles.contentBlock}>
        <div className="container">
          <div className={styles.contentGrid}>

            {/* Левая сторона: Описание */}
            <div className={styles.descriptionSide}>
              <AnimatePresence mode="wait">
                <motion.div
                  key={activeContent.id}
                  className={styles.textWrapper}
                  initial={{ x: 100, opacity: 0 }}
                  animate={{ x: 0, opacity: 1 }}
                  exit={{ x: -100, opacity: 0 }}
                  transition={{ duration: 0.35, ease: 'easeInOut' }}
                >
                  <p className={styles.description}>
                    {activeContent.description}
                  </p>
                </motion.div>
              </AnimatePresence>
            </div>

            {/* Правая сторона: Картинка */}
            <div className={styles.imageSide}>
              <div className={styles.imgContainer}>
                <AnimatePresence mode="wait">
                  <motion.img
                    key={activeContent.id}
                    src={activeContent.imageUrl}
                    alt="Collection item"
                    className={styles.img}
                    initial={{ y: '100%', opacity: 0 }}
                    animate={{ y: 0, opacity: 1 }}
                    exit={{ y: '-100%', opacity: 0 }}
                    transition={{ duration: 0.4, ease: 'easeInOut' }}
                  />
                </AnimatePresence>
              </div>
            </div>

          </div>
        </div>
      </div>
    </section>
  )
}
