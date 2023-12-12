import axios from "axios";

const REGISTER_API_URL = "http://localhost:8082/api/v1/register";

class registerService{

    registerUser(user){
        return axios.post(REGISTER_API_URL, user)
    }

}

export default new registerService();