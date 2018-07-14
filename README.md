# BookManageSystem
It's a book manage System includes the User Registe and Login, and Book category manage and Book manage and search functions.
For the registe and book added JSP file, we implement RegularExpression to check the input.
For the book search function, we implement Ajax and JSON to get it done by partially refreshing. We import JQuery library to actuzlize
Ajax module.
And we implement two filters, one is transferring all character set to Unicode "UTF-8", invoiding unstandard characters appear.
Another one is checking user's login status. Because the system is designed to be any function after login. This filter can block
any user who want to visit the search/add book page without login.

Use MVC structure. M-JavaBean V-Servlet C-JSP
