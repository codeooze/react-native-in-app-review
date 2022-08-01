
<br/>
<br/>

<img src="https://raw.githubusercontent.com/codeooze/react-native-in-app-review/main/inAppReview-package-icon.png" alt="drawing" width="150" height="150"/>

# @codeooze/react-native-in-app-review

The Google Play In-App Review API lets you prompt users to submit Play Store ratings and reviews without the inconvenience of leaving your app or game.

Generally, **@codeooze/react-native-in-app-review** flow can be triggered at any time throughout the user journey of your app. During the flow, the user has the ability to rate your app using the 1 to 5 star system and to add an optional comment. Once submitted, the review is sent to the Play Store and eventually displayed.

![enter image description here](https://developer.android.com/static/images/google/play/in-app-review/iar-flow.jpg)

## Installation


```sh
npm install @codeooze/react-native-in-app-review
```

  

## Usage

  

```js

import *as React from 'react';
import { openInAppReview } from '@codeooze/react-native-in-app-review'

const App = () => {
	
	//...

	const showInAppReview = () => {
		openInAppReview()
		.then((response)  =>  {
			//success
			Alert.alert(response)
		})
		.catch((error)  =>  {
			//failure
			Alert.alert(error.message)
		})
	}

	//...
	
}

```


## Contributing

  
See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

  

## License

MIT

 ## Buy me a coffee 
<a href="https://www.buymeacoffee.com/codeooze" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/v2/default-blue.png" alt="Buy Me A Coffee" style="height: 60px !important;width: 217px !important;" ></a>
