function fn() {

    var env = karate.env;

    if (!env) {
        env = 'dev';
    }

    karate.log('Running Environment:', env);

    var config = {
        username: 'Dharun',
        role: 'API Tester'
    };

    if (env == 'dev') {
        config.baseUrl = 'https://dummyjson.com';
    }

    else if (env == 'qa') {
        config.baseUrl = 'https://fakestoreapi.com';
    }

    return config;
}