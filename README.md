This app is built using Maps SDK. 
Implemented Markers, Polylines, Polygon and Circle.
If we want to show a snippet by default we need to add
showInfoWindow() to that marker but if we add it more than one marker it only shows for the 
last used one.
The Polylines are made using PolylineOptions in which the line
follows the order in which we add the marker. 
The Polygon is made using PolygonOptions in which the lines always form a
closed figure.
The Circle is made using CircleOptions in which we set center by latLong and radius
in metres while in our app we made a custom pattern using List of PatternItem consisting of 
Dot, Gap, and Dash.
As Markers have OnClick and OnDrag Listerners similarly these polylines,polygons and circle have such listeners 
which can be implemented by implements in Class Signature. Also, OnInfoWindowClick() also present activates when the snippet
is clicked. Using these PolylineOptions we can tweak with the way they are shown like preference of which line to be shown when 
overlapping ones are present, adding color to the line/ stroke and changing the stroke width and pattern and others.
Similarly, PolygonOptions and CircleOptions can be tweaked.

      ImageLeft showing the marker4 snippet and ImageRight showing marker1 snippet when clicked 
      yellow line(shown over black line coz of higher zIndex) -> polyline and black line with blue fill color -> polygon
<image src="https://github.com/sanjuray/MapMeExtended/assets/94555333/cc6963a6-f3c9-42b3-a94f-8591469fe17e" width=400 height=500/>
  <image src="https://github.com/sanjuray/MapMeExtended/assets/94555333/abc7a1e4-f95c-49c5-a4a3-021c057e9266" width=400 height=500/>
      
    ImageLeft showing the circle on the map  and ImageRight showing the custom pattern of circle
<image src="https://github.com/sanjuray/MapMeExtended/assets/94555333/0b0119b6-39c1-4f49-9627-06fab385ad20" width=400 height=500/>
<image src="https://github.com/sanjuray/MapMeExtended/assets/94555333/91802bf2-b5a1-4754-84a5-536f2ff95f41" width=400 height=500/>
