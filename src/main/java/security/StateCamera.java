package security;

public enum StateCamera 
{
	ON
	{

		@Override
		public void setDirection(DirectionCamera direction) 
		{
			this.direction = direction;
			System.out.println("Se cambió la dirección a " + this.direction);
		}
		
	},
	OFF
	{

		@Override
		public void setDirection(DirectionCamera direction)
		{
			System.out.println("No se puede cambiar la dirección estando la cámara apagada.");
		}
		
	};

	protected DirectionCamera direction;
	
	StateCamera()
	{
		// By default, the direction is center.
		direction = DirectionCamera.CENTER;
	}
	
	public DirectionCamera getDirection()
	{
		return direction;
	}
	
	public abstract void setDirection(DirectionCamera direction);
}
