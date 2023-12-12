import React, { useState } from 'react'
import RegisterService from '../services/RegisterService';


const Registration = () => {

  const [user, setUser] = useState({
    id : "",
    userName : "",
    email : "",
    password : ""
  })

  const handleChange = (e) =>{

    const value = e.target.value;
    setUser({...user,[e.target.name ] : value})

  }

  const registerUser = (e) =>{
      e.preventDefault();

      RegisterService.registerUser(user).then((response) =>{
      console.log(response)
    }).catch((error) => {
      console.log(error)
    })
  }


  return (
    <div className='formContainer'>
        <div className='formWrapper'>
            <form className='form'>
                <span className='title'>Register</span>

                <input
                type='text'
                name='userName'
                value={user.userName}
                onChange={ (e) => handleChange(e)}
                placeholder='name'/>

                <input 
                type='email'
                name='email'
                value={user.email}
                onChange={ (e) => handleChange(e)}
                placeholder='email'/>

                <input 
                type='password'
                name='password'
                value={user.password}
                onChange={ (e) => handleChange(e)}
                placeholder='password'/>


                <button
                onClick={(e) => registerUser(e)}
                >Sign up</button>

                  
                <p> You already have an account? <a href= "/Login"> Login</a> </p>
            </form>
        </div>
    </div>
  )
}

export default Registration