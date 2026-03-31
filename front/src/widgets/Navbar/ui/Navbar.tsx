import { Link, useLocation } from 'react-router-dom';
import styles from './Navbar.module.scss';
import logo from '../../../assets/icons/logo.svg';
import decoBorder from '../../../assets/icons/deco_border.svg';

export const Navbar = () => {
    const location = useLocation();
    const isHome = location.pathname === '/';

    if (isHome) {
        return (
            <nav className={styles.nav__home}>
                <div className="container">
                    <div className={styles.nav__home__content}>
                        <Link to="/" className={styles.nav__home__logo_link}>
                            <img src={logo} alt="Veloce Logo" className={styles.nav__home__logo} />
                        </Link>
                        
                        <div className={styles.nav__home__right}>
                            <div className={styles.nav__home__slogan}>
                                THE ZERO-PROOF APERITIF FOR MODERN LIVING.
                            </div>
                            <div className={styles.nav__home__divider} />
                            <ul className={styles.nav__home__links}>
                                <li className={styles.nav__home__item}>
                                    <Link to="/about" className={styles.nav__home__link}>ABOUT</Link>
                                </li>
                                <li className={styles.nav__home__item}>
                                    <Link to="/stocklists" className={styles.nav__home__link}>
                                        <span className={styles.nav__home__text__desktop}>FIND STOCKLISTS</span>
                                        <span className={styles.nav__home__text__mobile}>FIND US</span>
                                    </Link>
                                </li>
                                <li className={styles.nav__home__item}>
                                    <Link to="/contact" className={styles.nav__home__link}>CONTACT</Link>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div className={styles.nav__home__deco}>
                    {/* <img src={decoBorder} alt="" className={styles.nav__home__deco_img} /> */}
                </div>
            </nav>
        );
    }

    return (
        <nav className={styles.nav__others}>
            <div className="container">
                <div className={styles.nav__others__content}>
                    <Link to="/" className={styles.nav__others__logo_link}>
                        <img src={logo} alt="Veloce Logo" className={styles.nav__others__logo} />
                    </Link>
                    <ul className={styles.nav__others__links}>
                        <li className={styles.nav__others__item}>
                            <Link to="/about" className={styles.nav__others__link}>ABOUT</Link>
                        </li>
                        <li className={styles.nav__others__item}>
                            <Link to="/stocklists" className={styles.nav__others__link}>FIND US</Link>
                        </li>
                        <li className={styles.nav__others__item}>
                            <Link to="/contact" className={styles.nav__others__link}>CONTACT</Link>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    );
};
