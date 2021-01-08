import './styles.css'
import {ReactComponent as YoutubeIcon} from './Youtube.svg'
import {ReactComponent as InstagramIcon} from './Instagram.svg'
import {ReactComponent as LinkedinIcon} from './Linkedin.svg'
function Footer() {
    return (
        <footer className="main-footer">
            App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
            <div className="footer-icons">
                <a href="https://www.youtube.com/watch?v=OpWfkIhcBoY&feature=emb_title" target="_new"> 
                    <YoutubeIcon />
                </a>
                <a href="https://www.linkedin.com/" target="_new"> 
                    <LinkedinIcon/>
                </a>
                <a href="https://www.instagram.com/" target="_new"> 
                    <InstagramIcon />
                </a>
            </div>
        </footer>
    )
}

export default Footer;