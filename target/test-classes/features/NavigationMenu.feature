Feature: Check customer navigation menu items are working properly
Description: The purpose of the test is to check whether all menu items links are working fine.

DemoBlaze URL: https://www.demoblaze.com/index.html

	Scenario Outline: User is able to open navigation menu items
		Given DemoBlaze is available
		When User clicks "<NavigationItem>" menu item
		Then "<NavigationItem>" page is opened
		Examples:
			| NavigationItem |
			| Laptops        |
			| Monitors       |
			| Phones         |