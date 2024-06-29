# React Native

```sh
nvm install 18.12.1
nvm use 18.12.1
nvm alias default 18.12.1
npm install -g expo-cli
npx create-expo-app WeatherApp
cd WeatherApp
npm start

```

## Eslint

```sh
npm install eslint --save-dev
npx eslint --init # Use Version 8.x
npm install @react-native-community/eslint-config --save-dev
npm install --save-dev --save-exact prettier


```

## Prettier

```

touch .prettierrc.js

```

The content is:
```
module.exports = {
    bracketSpacing: true,
    singleQuote: true,
    tabWidth: 2,
    useTabs: false,
    TrailingComma: 'none',
    semi: false
};
```

## remove some packages
```bash
npm uninstall -g react-native-cli @react-native-community/cli
```
