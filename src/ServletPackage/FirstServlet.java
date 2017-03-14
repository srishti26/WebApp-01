package ServletPackage;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;


import com.omdbapi.Omdb;
import com.omdbapi.OmdbConnectionErrorException;
import com.omdbapi.OmdbMovieNotFoundException;
import com.omdbapi.OmdbSyntaxErrorException;
import com.omdbapi.Movie;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String _moviename = request.getParameter("moviename");
		FirstServlet f = new FirstServlet();
		if (request.getParameter("button1") != null) {
            f.movieName(response);
		}
		else if(request.getParameter("button2") != null) {
            
				try {
					f.search(response,_moviename);
				} catch (Exception ignore) {
					// TODO Auto-generated catch block
					ignore.printStackTrace();
				}
		}
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}
	public void movieName(HttpServletResponse response) throws IOException 
	{
		final Document document = Jsoup.connect("http://www.imdb.com/chart/top").get();
		for(Element row : document.select("table.chart.full-width tr")){
			
			final String title = row.select(".titleColumn").text();
			final String rating = row.select(".imdbRating").text();
			PrintWriter out = response.getWriter();
			out.print(title +" -> rating"+rating+ "\n");
			
	}
	
		
}
	public void search(HttpServletResponse response, String moviename) throws OmdbSyntaxErrorException, OmdbConnectionErrorException, OmdbMovieNotFoundException, IOException{
		
			Omdb o = new Omdb();
		
		try {
			o.searchOneMovie(moviename);
			
		} catch (Exception ignore) {
			
		}
		
		
		
	}
}

