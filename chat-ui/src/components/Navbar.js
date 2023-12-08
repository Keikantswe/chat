import React from 'react'
import myImage from '../images/logo.png';


const Navbar = () => {
  return (

    

    <div className='Navbar'>
    <img className='h-16  p-2' src={myImage} alt="Description" />

      <div className='User'>
        <img className='img' src=""  alt="" />
        <span>Silencer</span>
        <button>Logout</button>
      </div>

    </div>
  )
}

export default Navbar