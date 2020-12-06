# DTT-House-App
Going to use MVVM and room

I am going to explain some of the diffiulties that I encountered and how I solved them

# authenticating the API

before I could start, the API needed authenticating before I could retrieve any JSON. After hours of googling proved to be useless, I had to take matters into my own hands
and figure out where to plug the key and the value, and that is within the authorisation tab. The key is access-key, the value is 98bww4ezuzfePCYFxJEWyszbUXc7dxRx
and this must be added to the header. Don't forget

# views not showing in the cardview

this initial problem I ran into prevented me from progressing. The recycerview had cardviews inside that were empty. Not useful. I made the mistake
of not populating the cardview, while all along I thought that there was a problem in the logic of the program. It was a stupid mistake to forget to check
the cardview. Incredibly stupid. I found out the logic was working fine when I put a breakpoint at the houses array, to check whether it was populated or not 
and indeed it was populated. That's when I knew the views was at fault

# image not showing up

The textviews did finally show up but the images did not. To fix this problem, I made a binding class and imported the glide library. 
Afterwards, I added the baseUrl alongside the url path of the image. Looking at the individual elements, I saw that the image var was only holding something
like /uploads/image1 and this isn't helpful. It must acquire the entire URL like https://website.com/uploads/image1 so to solve this I appended the baseUrl
to the url within the binding class. You can see it in the files
