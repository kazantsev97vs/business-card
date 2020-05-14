import {Type} from "../util";

export default class  Service {

    BASE_URL = "http://localhost:8080";

    _GET = "GET";
    _POST = "POST";
    _PUT = "PUT";
    _DELETE = "DELETE";
    _PATCH = "PATCH";

    FETCH = async ( method, remainingUrlPart, body, headers ) => {

        // Составляемый URL
        const URL = this.BASE_URL + remainingUrlPart;

        // Базовые заголовки и добавляем оставщиеся заголовки, если они есть
        headers = {
            "Content-Type" : "application/json",
            ...headers
        };

        const init = {
            method,
            headers,
        };

        if (body) {
            init.body = Type.isString(body) ? body : JSON.stringify(body);
        }

        const fetchedData = await fetch(URL, init);

        return this.promise(fetchedData);
    };


    async GET ( url, headers) { return this.FETCH (this._GET, url, null, headers) }

    async POST ( url, body, headers ) { return this.FETCH (this._POST, url, body, headers ) }

    async PUT ( url, body, headers )  { return this.FETCH (this._PUT, url, body, headers ) }

    async DELETE ( url, body, headers ) { return this.FETCH (this._DELETE, url, body, headers) }

    async PATCH ( url, body, headers ) { return this.FETCH (this._PATCH, url, body, headers) }


    promise =  (response) =>  new Promise((resolve, reject) =>  {

        const result = response.json();

        if (response.status !== 200) {
            return reject(new Error(result));
        }

        return resolve(result);
    });
}

