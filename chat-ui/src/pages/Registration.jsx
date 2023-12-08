import React from 'react'

const Registration = () => {
  return (
    <div className='formContainer'>
        <div className='formWrapper'>
            <form className='form'>
                <span className='title'>Register</span>

                <input type='text' placeholder='name'/>
                <input type='email' placeholder='email'/>
                <input type='password' placeholder='password'/>
                <button>Sign up</button>

                <p> You already have an account? Login</p>
            </form>
        </div>
    </div>
  )
}

export default Registration