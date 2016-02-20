#1.0 System Overview
The Distance Converter app is designed for use with mobile devices built on the Android operating system. This app's primary function is to allow users to convert distances such as miles to feet, feet to inches, and meters to centimeters. Below is an image of the app and a brief description of each item on the application's interface.

![Distance Converter App](https://github.gatech.edu/gt-omscs-softeng/6300Spring16juwujaren6/blob/master/Assignment4/Documentation/DistanceConverter.png "Distance Converter App")

The Distance Converter App consists of two spinner or dropdown controls, one input field, one display field, and two buttons. The numbered list below highlights the numbered features in the image above.
1. The Convert From widget is a spinner or dropdown control that allows users to select the type of distance value they want to convert from. The default value for this widget is "Miles."
2. The Convert To widget is a spinner or drop control that allows users to select the type of distance value they want to convert to. The default value for this widget is "Kilometers."
3. The Value field is a control that allows users to specify a value for the Convert From field.
4. The Result field displays the results once the user clicks the Convert button.
5. The Convert button allows the user to view the Results of the conversion based on their selections.
6. The Clear button resets the values of the widgets back to their original values so that they user can enter new data.

#2.0 Using the Distance Converter App
The Distance Converter App is an easy application to use. The Convert From dropdown control allows user to select from a distant list of options for the distance type to convert from. The default value for this field is Miles. Additionally, the Convert To dropdown also provides users with the same list of options for the distance type to convert to. The default value for this field is Kilometers. The options include:

* Miles
* Feet
* Inches
* Kilometers
* Meters
* Centimeters

The Value field is a free-form text field that allows users to enter a value that the Distance Converter app will use to perform the conversion. Once the user has entered a value in the Value field, the user can use one of two buttons to either process the conversion or clear the screen to enter new values. 

Clicking the Convert button will display the result of the conversion in the Result field. However, clicking the Clear button will reset the the Convert From field back to the default value of "Miles" and the Convert To field to the default value of "Kilometers." The system will also remove any values from the Value and Result fields. 

In the event that the same values are selected by the user in the Convert From and Convert To fields, the system will pass the same value as the Value field as the result in the Result field.
